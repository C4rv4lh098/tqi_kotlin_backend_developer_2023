import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})



export class HomeComponent {
  constructor(private router: Router){}

  getNome(){
    var clienteNome = (document.getElementById("clienteNome") as HTMLInputElement).value;
    console.log(clienteNome);

    if (clienteNome == ""){
      console.log("nulo");
      alert("Nome inválido!")
    }
    else{
      this.router.navigate(["/compras"])
    }
  }
}
