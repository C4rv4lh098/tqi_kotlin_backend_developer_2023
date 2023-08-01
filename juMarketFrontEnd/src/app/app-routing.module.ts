import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { EstoqueComponent } from './estoque/estoque.component';
import { ComprasComponent } from './compras/compras.component';
import { CreateCategoriaComponent } from './categorias/create-categoria/create-categoria.component';
import { ReadCategoriaComponent } from './categorias/read-categoria/read-categoria.component';
import { CreatProdrutoComponent } from './prodrutos/creat-prodruto/creat-prodruto.component';
import { ReadProdrutoComponent } from './prodrutos/read-prodruto/read-prodruto.component';
import { CreatClientesComponent } from './clientes/creat-clientes/creat-clientes.component';
import { ReadCarrinhoComponent } from './read-carrinho/read-carrinho.component';

const routes: Routes = [
  //============ Rotas Principais ============//
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'estoque', component: EstoqueComponent},
  {path: 'compras', component: ComprasComponent},

  //============ Rotas Categorias ============//
  {path: 'categoria/cadastro', component: CreateCategoriaComponent},
  {path: 'categoria/consulta', component: ReadCategoriaComponent},


  //============ Rotas Produtos ============//
  {path: 'produto/cadastro', component: CreatProdrutoComponent},
  {path: 'produto/consulta', component: ReadProdrutoComponent},

  //============ Rota Clientes ============//
  {path: 'cliente/cadastro', component: CreatClientesComponent},

  //============ Rota Carrinho ============//
  {path: 'carrinho/{id}', component: ReadCarrinhoComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
