
import axios, { AxiosRequestConfig } from "axios";
import qs from "qs";

export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';

const CLIENT_ID = process.env.REACT_APP_CLIENT_ID ?? 'cabanas';

const CLIENT_SECRET = process.env.REACT_APP_CLIENT_SECRET ?? 'cabanas@123';

const tokenKey = 'authData';

type LoginResponse = {
        access_token: string;
        token_type: string;
        expires_in: number;
        scope: string;
        userName: string;
        userRole: string;
        userId: number;
}

type LoginData = {
    username: string;
    password: string;
}

export const requestBackendLogin = (loginData:LoginData) => {

    const headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        Authorization: 'Basic ' + window.btoa(CLIENT_ID + ':' + CLIENT_SECRET)
    }

    const data = qs.stringify({
        ...loginData,
        grant_type: 'password'
    });

    return axios({method: 'POST', baseURL:BASE_URL, url:'oauth/token', data, headers});
}

export const requestBackend = (config: AxiosRequestConfig) => {
    return axios({...config, baseURL: BASE_URL });
}

export const storeAuthData = (obj: LoginResponse) => {
    localStorage.setItem(tokenKey, JSON.stringify(obj));
}

export const getAuthData = () => {
    const str = localStorage.getItem(tokenKey)  ?? '{}';
    return JSON.parse(str) as LoginResponse;
}

axios.interceptors.request.use(function (config) {

    return config;
  }, function (error) {

    return Promise.reject(error);
  });


axios.interceptors.response.use(function (response) {

    return response;
  }, function (error) {

    return Promise.reject(error);
  });
