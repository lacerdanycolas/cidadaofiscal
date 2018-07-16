import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {

  @Input() recebevoluntario;

  volunteer = {
    id: '',
    nomeVoluntario: '',
    email: '',
    telefone: '',
    estado: '',
    causa: ''
  }

  status = false;
  cadastrado = false;

  constructor() {

  }

  ngOnInit() {
    this.volunteer = {
      id: '',
      nomeVoluntario: '',
      email: '',
      telefone: '',
      estado: '',
      causa: ''
    }
   this.status = false;
   this.cadastrado = false;
  }

  validatefields(){

    
    var volaux = this.volunteer;
    if(volaux.nomeVoluntario == "" || volaux.email == "" ||
      volaux.estado == "" || volaux.causa == ""
      || volaux.nomeVoluntario == null || volaux.email == null ||
      volaux.estado == null || volaux.causa == null ||
      volaux.nomeVoluntario == undefined || volaux.email == undefined ||
      volaux.estado == undefined || volaux.causa == undefined){
      this.status = true;
    }

    var usuario = volaux.email.substring(0, volaux.email.indexOf("@"));
    var dominio = volaux.email.substring(volaux.email.indexOf("@")+ 1, volaux.email.length);
    var bol ;
    if ((usuario.length >=1) &&
      (dominio.length >=3) &&
      (usuario.search("@")==-1) &&
      (dominio.search("@")==-1) &&
      (usuario.search(" ")==-1) &&
      (dominio.search(" ")==-1) &&
      (dominio.search(".")!=-1) &&
      (dominio.indexOf(".") >=1)&&
      (dominio.lastIndexOf(".") < dominio.length - 1)) {
      bol = false;
    }else{
        bol = true;
        this.status=bol;
    }


    return this.status;
  }

  sendVol(){

    if(!this.validatefields()) {
      var vol = this.volunteer;
      var json = JSON.stringify(vol);
      var xhr = new XMLHttpRequest();
      xhr.open("POST", 'http://localhost:5000/voluntarios/', true);


      xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');

      xhr.onload = function () {
        var volunteers = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == 200) {
          console.table(volunteers);
        } else {
          console.error(volunteers);
        }
      }
      xhr.send(json);
      this.status = false;
      this.cadastrado = true;
    }
  }


}
