import { Button } from 'bootstrap';
import ProductList from './User/UserProductList';
import React, { Component } from 'react';
import RegisterPage from './RegisterPage';
import { Link } from 'react-router-dom';
import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
import PersonIcon from '@mui/icons-material/Person';
import { Navbar } from 'react-bootstrap'
import "bootstrap/dist/css/bootstrap.min.css";
import '../App.css';

function BaseLocation(){
    return <div className='App'>
        <h1>Apna Bazaar</h1> 
        <nav>
        <Navbar bg="light" expand="lg">
        <Link to='/registration' style={{textDecoration: 'none'}}><PersonIcon/> Customer</Link>
        {/* <Link to='/admin'> Admin</Link> */}
        <Link to='/adminlogin' style={{textDecoration: 'none'}}><AdminPanelSettingsIcon/>Admin</Link> 
        </Navbar>
        </nav>
        <div>
            {<ProductList/>}
        </div>  
        </div>
}
export default BaseLocation;