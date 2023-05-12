import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { lastValueFrom } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ArchiveService {

  constructor(private httpClient: HttpClient) { }

  postToBackend(formdata: FormData) {
    const headers = new HttpHeaders()
                  .set('Accept', 'application/json')
                  .set('Content-Type', 'multipart/form-data')

    return lastValueFrom(this.httpClient.post<any>("upload", formdata,{ headers: headers })).then(() => {console.log("posted successfully to backend")}).catch((error) => console.log(error));
  }
}
