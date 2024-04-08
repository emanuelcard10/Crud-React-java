
import './App.css';
import ListClienteComponent from './components/ListClienteComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import { BrowserRouter,Routes , Route } from 'react-router-dom';
import AddClienteComponent from './components/AddClienteComponent';
function App() {
  return (
    <div>
    <BrowserRouter>
      <HeaderComponent />
      <div className='container'>
        <Routes>
          <Route path='/' element={<ListClienteComponent />} />
          <Route path='/clientes' element={<ListClienteComponent />} />
          <Route path='/add-cliente' element={<AddClienteComponent />} />
          <Route path='/edit-cliente/:id' element={<AddClienteComponent />} />
          
        </Routes>
      </div>
      <FooterComponent />
    </BrowserRouter>
  </div>
  );
}

export default App;
