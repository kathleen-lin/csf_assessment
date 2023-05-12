import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListComponent } from './components/list.component';
import { UploadComponent } from './components/upload.component';
import { ContentComponent } from './components/content.component';

const routes: Routes = [
  { path: '', component: ListComponent },
  { path: 'save', component: UploadComponent },
  { path: 'archive/:bundleID', component: ContentComponent },
  { path: "**", redirectTo:'/', pathMatch: 'full'}
  ];;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
