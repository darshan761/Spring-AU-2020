import { FETCH_POLLUTION_SUCCESS, FETCH_POLLUTION_ERROR, SEARCH_POLLUTION_CITY, FETCH_FROM_LOCAL } from './action';

const initialState = {
    pollution: [],
    copy: [],
    error: null
}

export function fetchReducer(state = initialState, action) {
    switch (action.type) {
        case FETCH_POLLUTION_SUCCESS:
            console.log("Successh=====")
            console.log(state.copy)
            return {
                ...state,
                pollution: action.pollution,
                copy: action.copy,
            }
        case FETCH_POLLUTION_ERROR:
            return {
                ...state,
                error: action.error
            }
        case SEARCH_POLLUTION_CITY:
            let r = new RegExp(action.regex);
            console.log("Search=====")
            console.log(state.copy)
            return {
                ...state,
                pollution: state.copy.filter(x =>
                    r.test(x.city)
                ),
            }
        case FETCH_FROM_LOCAL:
            console.log("Fetching===");
            console.log(state.complete)
            return {
                ...state,
                copy: action.complete,
                pollution: JSON.parse(localStorage.getItem("item"))
            }
        default:
            return state;
    }
}