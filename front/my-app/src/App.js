import logo from './logo.svg';
import Menu from './components/Menu/Menu';
import './App.css';

function App() {
  return (
    <>
      <Menu/>
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Bienvenido a la app de demo para <code>Wupo</code>
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer">
            Repositorio de GitHub
          </a>
        </header>
      </div>
    </>
  );
}

export default App;
