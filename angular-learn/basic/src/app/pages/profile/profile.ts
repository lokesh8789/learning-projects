import { Component, inject, input, Signal, signal } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { map } from 'rxjs';
import { PostService } from '../../services/post-service';
import { toSignal } from '@angular/core/rxjs-interop';
import { JsonPipe } from '@angular/common';

@Component({
  imports: [JsonPipe, RouterLink],
  selector: 'app-profile',
  styleUrl: './profile.css',
  templateUrl: './profile.html',
})
export class Profile {
  id = input.required<string>();
  title = input.required<string>();


  activatedRoute = inject(ActivatedRoute)
  private postService = inject(PostService)

  posts = toSignal(this.postService.getPosts(), { initialValue: [] })

  postStream = signal<Post[]>([]);

  constructor() {
    // alternate to get path var
    this.activatedRoute.paramMap.subscribe({
      next: (map) => console.log("paramVal: " + map.get("id"))
    })
  }

  ngOnInit() {
    this.postService.getPostStream()
      .subscribe({
        next: (value) => {
          this.postStream.update(post => [ ...post, value])
        }
      })
  }
}
