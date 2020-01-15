export const FETCH_POLLUTION_SUCCESS = 'FETCH_POLLUTION_SUCCESS';
export const FETCH_POLLUTION_ERROR = 'FETCH_POLLUTION_ERROR';
export const SEARCH_POLLUTION_CITY = 'SEARCH_POLLUTION_CITY';
export const FETCH_FROM_LOCAL = 'FETCH_FROM_LOCAL';

export function fetchPollutionSuccess(pollution) {
    return {
        type: FETCH_POLLUTION_SUCCESS,
        pollution: pollution,
        copy: pollution
    }
}

export function fetchPollutionError(error) {
    return {
        type: FETCH_POLLUTION_ERROR,
        error: error
    }
}

export function fetchFromLocal(pollution) {
    console.log("fetch from local")
    console.log(pollution)
    return {
        type: FETCH_FROM_LOCAL,
        complete: pollution

    }
}

export function searchCity(reg) {
    return {
        type: SEARCH_POLLUTION_CITY,
        regex: reg,
    }
}