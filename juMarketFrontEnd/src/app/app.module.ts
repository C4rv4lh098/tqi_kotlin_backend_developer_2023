import { HeaderCompraComponent } from './header-compra/header-compra.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { EstoqueComponent } from './estoque/estoque.component';
import { ComprasComponent } from './compras/compras.component';
import { HeaderEstoqueComponent } from './header-estoque/header-estoque.component';
import { CreateCategoriaComponent } from './categorias/create-categoria/create-categoria.component';
import { ReadCategoriaComponent } from './categorias/read-categoria/read-categoria.component';
import { ReadProdrutoComponent } from './prodrutos/read-prodruto/read-prodruto.component';
import { CreatProdrutoComponent } from './prodrutos/creat-prodruto/creat-prodruto.component';
import { CreatClientesComponent } from './clientes/creat-clientes/creat-clientes.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReadCarrinhoComponent } from './read-carrinho/read-carrinho.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderCompraComponent,
    EstoqueComponent,
    ComprasComponent,
    HeaderEstoqueComponent,
    CreateCategoriaComponent,
    ReadCategoriaComponent,
    ReadProdrutoComponent,
    CreatProdrutoComponent,
    CreatClientesComponent,
    ReadCarrinhoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
