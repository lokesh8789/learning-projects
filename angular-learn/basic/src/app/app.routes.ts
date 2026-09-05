import { Routes } from '@angular/router';
import { NotFound } from './pages/not-found/not-found';
import { Profile } from './pages/profile/profile';
import { Login } from './pages/login/login';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
    },
    {
        path: 'login',
        component: Login
    },
    {
        path: 'profile/:id',
        component: Profile,
        data: {
            title: "User Profile"
        }
    },
    {
        path: '**',
        component: NotFound
    }
];
