import {defineStore} from "pinia";
import apiService from "../services/apiService";

const baseUrl = `/api/users/all`;

export const useUsersStore = defineStore({
    id: 'users',
    state: () => ({
        users: {}
    }),
    actions: {
        async getAll() {
            this.users = {loading: true};
            apiService.get(baseUrl)
                .then(users => this.users = users)
                .catch(error => this.users = {error})
        }
    }
});