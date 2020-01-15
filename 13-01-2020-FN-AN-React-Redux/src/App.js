import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
  
        <br></br>
        <input id="name" type="text"></input>
        <br></br>
        <input type="button" value="Submit"/>
    
        <h1 id="display"></h1>
      </header>
    </div>
  );
}

export default App;
