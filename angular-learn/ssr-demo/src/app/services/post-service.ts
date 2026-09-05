import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { from, mergeMap, take, tap, toArray } from 'rxjs';
import { Post } from '../models/post';

@Service()
export class PostService {
    private http = inject(HttpClient);

    getPosts() {
        return this.http.get<Post[]>('https://jsonplaceholder.typicode.com/posts')
            .pipe(
                tap(posts => {
                    const now = new Date();

                    const ist = now.toLocaleString('en-IN', {
                        timeZone: 'Asia/Kolkata',
                        year: 'numeric',
                        month: '2-digit',
                        day: '2-digit',
                        hour: '2-digit',
                        minute: '2-digit',
                        second: '2-digit',
                        fractionalSecondDigits: 3,
                        hour12: false
                    });
                    console.log("********** Post is rendered here ************", ist)
                }),
                mergeMap(posts => from(posts)),
                take(2),
                toArray()
            )
    }
}
