import 'hammerjs';

import {NgModule} from "@angular/core";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthentificationComponent } from './components/authentification/authentification.component';
import { UserFormsComponent } from './components/user-forms/user-forms.component';
import { EditPasswordComponent } from "./components/edit-password/edit-password.component";
import { FillFormComponent } from './components/fill-form/fill-form.component';
import { NavbarComponent } from './shared/components/navbar/navbar.component';
import { FieldComponent } from "./components/build-form/field/field.component";
import { BuildFormComponent } from "./components/build-form/build-form.component";
import { FieldOfTypeComponent } from './components/build-form/field/field-of-type/field-of-type.component';
import { TypeShortTextComponent } from './components/build-form/field/field-of-type/type-short-text/type-short-text.component';
import { TypeLongTextComponent } from './components/build-form/field/field-of-type/type-long-text/type-long-text.component';
import { TypeSingleChoiceComponent } from './components/build-form/field/field-of-type/type-single-choice/type-single-choice.component';
import { TypeMultipleChoiceComponent } from './components/build-form/field/field-of-type/type-multiple-choice/type-multiple-choice.component';
import { TypeDateComponent } from './components/build-form/field/field-of-type/type-date/type-date.component';
import { TypeLinearScaleComponent } from './components/build-form/field/field-of-type/type-linear-scale/type-linear-scale.component';
import { FormPreviewComponent } from './components/user-forms/form-preview/form-preview.component';
import { DialogShareComponent } from './components/user-forms/form-preview/form-preview.component';
import { DialogDeleteComponent } from './components/edit-password/edit-password.component';


import {FillFormService} from "app/shared/services/fill-form/fill-form.service";
import { FillFieldComponent } from './components/fill-form/fill-field/fill-field.component';
import { FillFieldOfTypeComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-field-of-type.component';
import { FillTypeDateComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-date/fill-type-date.component';
import { FillTypeLinearScaleComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-linear-scale/fill-type-linear-scale.component';
import { FillTypeLongTextComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-long-text/fill-type-long-text.component';
import { FillTypeMultipleChoiceComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-multiple-choice/fill-type-multiple-choice.component';
import { FillTypeShortTextComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-short-text/fill-type-short-text.component';
import { FillTypeSingleChoiceComponent } from './components/fill-form/fill-field/fill-field-of-type/fill-type-single-choice/fill-type-single-choice.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { SimplenavbarComponent } from './shared/components/simplenavbar/simplenavbar.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthentificationComponent,
    DialogDeleteComponent,
    DialogShareComponent,
    EditPasswordComponent,
    UserFormsComponent,
    FillFormComponent,
    NavbarComponent,
    FieldComponent,
    BuildFormComponent,
    FieldOfTypeComponent,
    TypeShortTextComponent,
    TypeLongTextComponent,
    TypeSingleChoiceComponent,
    TypeMultipleChoiceComponent,
    TypeDateComponent,
    TypeLinearScaleComponent,
    FormPreviewComponent,
    FillFieldComponent,
    FillFieldOfTypeComponent,
    FillTypeDateComponent,
    FillTypeLinearScaleComponent,
    FillTypeLongTextComponent,
    FillTypeMultipleChoiceComponent,
    FillTypeShortTextComponent,
    FillTypeSingleChoiceComponent,
    EditProfileComponent,
    SimplenavbarComponent
  ],
  imports: [
    AppRoutingModule
  ],
  providers: [
    FillFormService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
