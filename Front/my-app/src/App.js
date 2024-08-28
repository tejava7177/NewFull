import React from 'react';
import logo from './logo.svg';
import './App.css';
import TextInputComponent from './components/TextInputComponents'; // 이 경로가 정확한지 확인하세요

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <TextInputComponent /> {/* TextInputComponent를 추가하여 화면에 표시 */}
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
