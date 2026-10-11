export interface User {
  id: number;
  name: string;
  email: string;
}

export interface LoginResponse {
  user: User;
  token: string;
  expiration: string;
}

export interface RegisterPayload {
  name: string;
  email: string;
  password: string;
}

export interface RegisterResponse {
  message?: string;
  user?: User;
  id?: number;
}

export interface LoginPayload {
  userName: string;
  password: string;
}
