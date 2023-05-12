import { Component } from '@angular/core';
import { Bundle } from '../model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {

  listOfBundle!: Bundle[]
}
