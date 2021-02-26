import React from "react";
import axios from "axios";
import { BrowserRouter, Route, Switch, Link } from "react-router-dom";
import BookDetails from "./BookDetails";

class BookList extends React.Component{
    constructor(props)
    {
        super(props)
        this.state={
            books:[]
        }
    }

    componentDidMount()
    {
        axios.get('http://localhost:3001/books')
        .then(response => {
            console.log(response)
            this.setState({books:response.data})
        }).catch(error=>{
            console.log(error)
            //this.state({errorMsg:"Error retreiving Data"})
        })
    }
    render(){
        const { books,errorMsg }=this.state
        return(
           
            <div>
                 <BrowserRouter>
                <h4>List of Books</h4>
                <div>
                    {
                        books.length ? books.map(book=>
                        <div class="newDiv">
                            <p key={book.bookid}><Link to={"/"+book.bookid}>{book.name} </Link></p>
                        </div>): null
                    }
                    
                   
                </div>
                
                {errorMsg ? <div>{errorMsg}</div>:null }
                </BrowserRouter>
            </div>
            
        )
    }
}
export default BookList;