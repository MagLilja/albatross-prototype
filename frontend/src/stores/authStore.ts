import { defineStore } from 'pinia';
import ApiService from "../services/apiService";
import router from "../router";

export const useAuthStore = defineStore({
    id: 'auth',
    state: () => ({
        // initialize state from local storage to enable user to stay logged in
        user: JSON.parse(localStorage.getItem('user') as string),
        returnUrl: null
    }),
    actions: {
        async login(username: string, password: string) {
            const user = await ApiService.post(`/api/auth/signin`, { username, password });
            // update pinia state
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