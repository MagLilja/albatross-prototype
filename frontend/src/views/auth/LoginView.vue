<script setup lang="ts">
import {Form, Field} from 'vee-validate';
import * as Yup from 'yup';
import {useAuthStore} from "../../stores/authStore";


const schema = Yup.object().shape({
    username: Yup.string().required('Username is required'),
    password: Yup.string().required('Password is required')
});

function onSubmit(values: { username: string, password: string }, {setErrors}) {
    const authStore = useAuthStore();
    const {username, password} = values;

    return authStore.login(username, password)
        .catch(error => setErrors({apiError: error}));
}
</script>

<template>
    <div class="flex items-center justify-center flex-col pt-44 ">
        <div class="my-12">
            Username: mod<br/>
            Password: yrgoP4ssword
        </div>
        <h2>Login</h2>
        <Form @submit="onSubmit" :validation-schema="schema" v-slot="{ errors, isSubmitting }" class="w-56">
            <div class="">
                <label>Username</label>
                <Field name="username" type="text" class="" :class="{ 'text-red': errors.username }"/>
                <div class="invalid-feedback">{{ errors.username }}</div>
            </div>
            <div class="">
                <label>Password</label>
                <Field name="password" type="password" class="form-control" :class="{ 'is-invalid': errors.password }"/>
                <div class="invalid-feedback">{{ errors.password }}</div>
            </div>
            <div class="form-group">
                <button class="" :disabled="isSubmitting">
                    <span v-show="isSubmitting" class="spinner-border spinner-border-sm mr-1"></span>
                    Login
                </button>
            </div>
            <div v-if="errors.apiError" class="alert alert-danger mt-3 mb-0">{{ errors.apiError }}</div>
        </Form>
    </div>
</template>