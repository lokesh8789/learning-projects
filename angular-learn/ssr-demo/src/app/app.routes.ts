import { Routes } from '@angular/router';
import { Post } from './post/post';
import { Profile } from './profile/profile';

export const routes: Routes = [
    {
        path: "posts",
        component: Post
    },
    {
        path: "profile",
        component: Profile
    }
];
