import React from "react";
import axios from "axios";
axios.defaults.withCredentials = false
export default class RegisterPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            userEmail: "",
            userId: "",
            userName: "",
            password: "",
            uFirstName: "",
            uLastName: "",
            userAddress: "",
            phone:"" 
        };
        this.onChangeUserEmail = this.onChangeUserEmail.bind(this);
        this.onChangeUserId = this.onChangeUserId.bind(this);
        this.onChangeUserName = this.onChangeUserName.bind(this);
        this.onChangePassword = this.onChangePassword.bind(this);
        this.onChangeFirstName =  this.onChangeFirstName.bind(this);
        this.onChangeLastName =  this.onChangeLastName.bind(this);
        this.onChangeUserAddress = this.onChangeUserAddress.bind(this);
        this.onChangePhone = this.onChangePhone.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChangeUserEmail(e) {
        this.setState({
            userEmail: e.target.value
          });
    }

     onChangeUserId(e) {
        this.setState({
            userId: e.target.value
          });
    }

    onChangeUserName(e) {
        this.setState({
            userName: e.target.value
          });
    }

    onChangeFirstName(e) {
        this.setState({
            uFirstName: e.target.value
          });
    }

    onChangeLastName(e) {
        this.setState({
            uLastName: e.target.value
          });
    }

    onChangeUserAddress(e) {
        this.setState({
            userAddress: e.target.value
          });
    }

    onChangePhone(e) {
        this.setState({
            phone: e.target.value
          });
    }

    onChangePassword(e) {
        this.setState({
            password: e.target.value
          });
    }


    
    async onSubmit(e) {
        
        await axios.post("http://localhost:8080/user/registration", {
            userEmail: this.state.userEmail,
            userId: this.state.userId,
            userName: this.state.userName,
            password: this.state.password,
            uFirstName: this.state.uFirstName,
            uLastName: this.state.uLastName,
            userAddress: this.state.userAddress,
            phone: this.state.phone
        })
        .then((res) => {
            alert(this.state.userName + " is registered succesfully");
            alert(res.status);
            window.location='/login';

        })
        .catch((err) => {
            alert(err);
        })
    }

    render() {
        return (
            <form onSubmit={this.onSubmit}>

                <h3>Register</h3>

                <div className="form-group">
                    <label>User Email</label>
                    <input value={this.state.userEmail} onChange={this.onChangeUserEmail} id="userEmail" type="email" className="form-control" placeholder="Enter userEmail" required/>
                </div> 
                
                <div className="form-group">
                    <label>User id</label>
                    <input value={this.state.userId} onChange={this.onChangeUserId} id="userId" type="text" className="form-control" placeholder="Enter userId" required/>
                </div>
                
                <div className="form-group">
                    <label>User Name</label>
                    <input value={this.state.userName} onChange={this.onChangeUserName} id="userName" type="text" className="form-control" placeholder="Enter userName" required/>
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input value={this.state.password} onChange={this.onChangePassword} id="password" type="password" className="form-control" placeholder="Enter password" required/>
                </div>

                
                <div className="form-group">
                    <label>First Name</label>
                    <input value={this.state.uFirstName} onChange={this.onChangeFirstName} id="userFirstName" type="text" className="form-control" placeholder="Enter FirstName" required/>
                </div> 

                <div className="form-group">
                    <label>Last Name</label>
                    <input value={this.state.uLastName} onChange={this.onChangeLastName} id="userLastName" type="text" className="form-control" placeholder="Enter LastName" required/>
                </div>

                <div className="form-group">
                    <label>Phone</label>
                    <input value={this.state.phone} onChange={this.onChangePhone} id="userPhone" type="tel" className="form-control" placeholder="123-45-678" required/>
                </div>

                <div className="form-group">
                    <label>Address</label>
                    <input value={this.state.userAddress} onChange={this.onChangeUserAddress} id="userAddress" type="text" className="form-control" placeholder="Enter Address" required/>
                </div>

                <button type="submit" className="btn btn-dark btn-lg btn-block">Create account</button>
                <p className="forgot-password text-right">
                    Already have an <a href="/login">account</a>?
                </p>
            </form>
        );
    }
}
