import { fetchPollutionSuccess, fetchPollutionError } from '../action';


export function fetchPollution() {

    return dispatch => {
        fetch("./data.json")
            .then(res => res.json())
            .then(res => {
                dispatch(fetchPollutionSuccess(res.pollution));
                return res.pollution;
                console.log("res" + res.id);
            })
            .catch(error => {
                dispatch(fetchPollutionError(error));
            })
    }

}


// export default fetchPollution;