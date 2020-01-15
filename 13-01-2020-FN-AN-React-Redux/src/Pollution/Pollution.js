import React, { Component } from 'react';
import { fetchPollutionSuccess, fetchPollutionError, searchCity, fetchFromLocal } from '../action';
import { connect } from 'react-redux';
import './Pollution.css';

class Pollution extends Component {

    componentDidMount(){
        fetch("./data.json")
        .then(res => res.json())
        .then(res => {
          if(localStorage.getItem("present")){
            document.getElementById("search").value = localStorage.getItem("input");
            this.props.dispatch(fetchFromLocal(res));
            console.log("Already there");
          }
          else{
            this.props.dispatch(fetchPollutionSuccess(res));
            console.log("Not there");
            // return res;
          }
          console.log("End here")
        })
        .catch(error => {
          this.props.dispatch(fetchPollutionError(error));
        })
  }

   search=(e)=>{
    let regex = e.target.value;
    this.props.dispatch(searchCity(regex));
    localStorage.setItem("input", regex);
  }

  save = () =>{
    localStorage.setItem("present", true);
    localStorage.setItem("item",JSON.stringify(this.props.pollution));
  }
  
  render() {
     
    // console.log(this.props.pollution);
      return ( 
      <div className = "Pollution" >
        <center>
        <div >
            <h1>Pollution Data</h1>
          </div>    
          <input id="search" onKeyUp={this.search} placeholder="Search City"></input>
          <button id="save" class="btn btn-primary" onClick={this.save}>Save to Local Storage</button>
        </center>
          
          <table align="center" border="1">
              <tr>
                <th>ID</th>
                <th>country</th>
                <th>state</th>
                <th>city</th>
                <th>station</th>
                <th>last_update</th>
                <th>pollutant_id</th>
                <th>pollutant_min</th>
                <th>pollutant_max</th>
                <th>pollutant_avg</th>
                <th>pollutant_unit</th>
              </tr>
          { this.props.pollution.map( x => {
            return(
              
              <tr>
                <td>{x.id}</td>
                <td>{x.country}</td>
                <td>{x.state}</td>
                <td>{x.city}</td>
                <td>{x.station}</td>
                <td>{x.last_update}</td>
                <td>{x.pollutant_id}</td>
                <td>{x.pollutant_min}</td>
                <td>{x.pollutant_max}</td>
                <td>{x.pollutant_avg}</td>
                <td>{x.pollutant_unit}</td>
              </tr>
           
            )
          }) }  </table>
         
          </div >
      ); }
  
}


const mapStateToProps = state => ({
  error: state.error,
  pollution: state.pollution,
  copy: state.copy

})

export default connect(
  mapStateToProps
)(Pollution);
