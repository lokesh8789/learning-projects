import { Component, inject } from '@angular/core';
import { PostService } from '../services/post-service';
import { toSignal } from '@angular/core/rxjs-interop';
import { JsonPipe } from '@angular/common';
import { RouterLink } from "@angular/router";

@Component({
  imports: [JsonPipe, RouterLink],
  selector: 'app-post',
  styleUrl: './post.css',
  templateUrl: './post.html',
})
export class Post {
  private postService = inject(PostService)

  posts = toSignal(this.postService.getPosts(), { initialValue: [] })
}
