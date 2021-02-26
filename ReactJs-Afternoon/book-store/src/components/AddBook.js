import React from "react";
import axios from "axios";

class AddBook extends React.Component{

    constructor(props){
        super(props)
        this.state={
            bookid:'',
            name:'',
            description:''
        }
        this.handleChange=this.handleChange.bind(this)
        this.handleSubmit=this.handleSubmit.bind(this)
    }

    handleChange=(e)=>{
        this.setState({[e.target.name]:e.target.value})
    }

    handleSubmit=(e)=>{
        e.preventDefault();
        console.log(this.state);
        axios.post('http://localhost:3000/books',this.state)
        .then(response =>{
            console.log(response)
            this.setState({books:response.data})
        }).catch(error => {
            console.log(error)
        })
        window.location.reload();
    }

    render(){
        const { bookid,name,description }=this.state
        return(
            <div>
                <form onSubmit={this.handleSubmit}>
                
                    <label for="bi">Book ID </label>
                        <input type="text" name="bookid" value={bookid} id="bi" onChange={this.handleChange}/>
                    <br/><br/>
                    <label for="b">Enter Name of Book </label>
                        <input type="text" name="name" value={name} id="b" onChange={this.handleChange} placeholder="Name some classics"/>
                        <br/><br/>
                    <label for="tb">Description </label>
                        <textarea id="tb" name="description" value={description} onChange={this.handleChange} placeholder="About the book" rows="5" cols="50" />
                        <br/> <br/>
                    <button>ADD</button><br/><br/>
                    
                </form>
            </div>
        )
    }
}

export default AddBook;