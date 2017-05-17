import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth/auth.service';
import { FileSelectDirective, FileDropDirective, FileUploader } from 'ng2-file-upload/ng2-file-upload';
import {baseUrl} from '../../globals';
import {MdIconRegistry} from '@angular/material';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'formy-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  public uploader:FileUploader = new FileUploader({url: `${baseUrl}/v1/forms`, method: 'PUT', disableMultipart : true});
  public username : string;

  constructor(private authService : AuthService, mdIconRegistry: MdIconRegistry, sanitizer: DomSanitizer) {
    mdIconRegistry
      .addSvgIcon('upload',
        sanitizer.bypassSecurityTrustResourceUrl('../assets/images/Downloaded.svg'));
  }

  public logout() {
    this.authService.setLoginStatus(false);
  }

  ngOnInit() {
    this.username = this.authService.getUsername();
  }

}
