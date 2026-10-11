export const API_CONFIG = {
  BASE_URL: 'http://localhost:8080/login-service',
  ENDPOINTS: {
    LOGIN: '/api/login',
    REGISTER: '/users/register',
    OAUTH_AUTH: '/oauth2/authorization',
  },
} as const;

export const STORAGE_KEYS = {
  AUTH_TOKEN: 'auth_token',
  AUTH_USER: 'auth_user',
} as const;
