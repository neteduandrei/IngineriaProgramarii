import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'formy-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {
  editDetails : EditDetails;
  constructor() { this.editDetails = new EditDetails();}

  ngOnInit() {
  }

}
class EditDetails {
  public name: string;
  public email: string;
}