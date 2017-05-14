import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth/auth.service';
import { FileSelectDirective, FileDropDirective, FileUploader } from 'ng2-file-upload/ng2-file-upload';
import {baseUrl} from '../../globals';

@Component({
  selector: 'formy-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  public uploader:FileUploader = new FileUploader({url: `${baseUrl}/v1/forms`, method: 'PUT', disableMultipart : true});
  public username : string;

  constructor(private authService : AuthService) {
  }

  public logout() {
    this.authService.setLoginStatus(false);
  }

  ngOnInit() {
    this.username = this.authService.getUsername();
  }

}
