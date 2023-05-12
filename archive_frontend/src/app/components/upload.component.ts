import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { ArchiveService } from '../service/archive.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit{

  @ViewChild('file')
  archiveFile!: ElementRef

  form!: FormGroup

  constructor (private fb: FormBuilder, private archiveService: ArchiveService, private router: Router) {}

  ngOnInit(): void {

    this.form = this.fb.group({
      name: this.fb.control<string>('', [Validators.required]),
      title: this.fb.control<string>('',[Validators.required]),
      comments: this.fb.control<string>('',),
      archive: this.fb.control<any>('', [Validators.required])
      
    })
  }

  postForm() {
    const formData = new FormData()
    formData.set("name", this.form.get("name")?.value) 
    formData.set("title", this.form.get("title")?.value) 
    formData.set("comments", this.form.get("comments")?.value)
    formData.set("archive", this.archiveFile.nativeElement.files[0])
    // console.log(formData.get("archive")) 
    this.archiveService.postToBackend(formData).then(() => { this.router.navigate(['/'])})
    
  }

  backHome() {
    this.router.navigate(['/'])
  }

  
}
