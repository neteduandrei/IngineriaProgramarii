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
import { DialogDeleteComponent } from './components/edit-password/edit-password.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthentificationComponent,
    DialogDeleteComponent,
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
    FormPreviewComponent
  ],
  imports: [
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
