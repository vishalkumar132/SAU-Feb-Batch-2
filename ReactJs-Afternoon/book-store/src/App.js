import React from 'react';

import { BrowserRouter, Route, Switch } from "react-router-dom";
import AddBook from './components/AddBook';
import BookList from "./components/BookList";
class App extends React.Component
{
    render(){    
        return(
        
        <div className="App">
            
            <div class="container">
            <h1>Best Books Ever!!</h1>
                    <div id="newtask">
                        <AddBook/>
                    </div>
                    <div id="tasks"><BookList/></div>
                </div>
            </div>
        
        )
    }
}

export default App;