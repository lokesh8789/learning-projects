export interface LoginModel {
  email: string,
  password: string,
  country: string,
  state: string
}

export const createInitialLoginForm = (): LoginModel => {
  return {
    email: '',
    password: '',
    country: '',
    state: ''
  };
}