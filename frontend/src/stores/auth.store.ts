import { defineStore } from 'pinia';
import ApiService from "../services/apiService";
import router from "../router";

export const useAuthStore = defineStore({
    id: 'auth',
    state: () => ({
        // initialize state from local storage to enable user to stay logged in
        user: JSON.parse(localStorage.getItem('user')),
        returnUrl: null
    }),
    actions: {
        async login(username, password) {
            console.log("hej");

            const userPromise = await ApiService.postDataTo(`auth/signin`, { username, password });
            const user = await userPromise.json();
            // update pinia state
            console.log(user);
            this.user = user;
            // store user details and jwt in local storage to keep user logged in between page refreshes
            localStorage.setItem('user', JSON.stringify(user));

            // redirect to previous url or default to home page
            router.push(this.returnUrl || '/');
        },
        logout() {
            this.user = null;
            localStorage.removeItem('user');
            router.push('/login');
        }
    }
});