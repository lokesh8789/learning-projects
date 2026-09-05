import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { concatMap, delay, from, mergeMap, of, take, toArray } from 'rxjs';

@Service()
export class PostService {
    private http = inject(HttpClient);

    getPosts() {
        return this.http.get<Post[]>('https://jsonplaceholder.typicode.com/posts')
            .pipe(
                mergeMap(posts => from(posts)),
                take(2),
                toArray()
            )
    }

    getPostStream() {
        return this.http.get<Post[]>('https://jsonplaceholder.typicode.com/posts')
            .pipe(
                mergeMap(posts => from(posts)),
                take(5),
                concatMap(post => of(post).pipe(delay(1000)))
            )
    }

}
