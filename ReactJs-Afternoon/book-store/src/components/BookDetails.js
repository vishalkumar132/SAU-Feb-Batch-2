import React, { useEffect, useState } from "react";
import axios from "axios";
import { BrowserRouter, Route, Switch, Link } from "react-router-dom";

function BookDetails(props){

    useEffect( ()=> {
        fetchBook();
    },[]);

    const [book,setItem]=useState([]);

    const fetchBook= async () =>{
        
        const bid=props.match.params.id;
        const fetchBook= await fetch('http://localhost:3001/books/'+bid);
        const book= await fetchBook.json();
        setItem(book);
    };
    console.log("hiihgkufk");
    console.log(book);

    return(
        <div id="tasks">
            <h4>Book Name:   {book.name}</h4> 
            <h4>Book description:   {book.description}</h4>
        </div>
    )
}


export default BookDetails;