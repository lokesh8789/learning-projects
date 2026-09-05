export const sleep = (ms: number) => new Promise(resolve => setTimeout(resolve, ms));

export const countryList: string[] = [
    "india",
    "usa",
    "china",
    "japan"
];

export const stateList: Record<string, string[]> = {
    "india": ["bihar", "up", "haryana"],
    "usa": ["newyork", "seattle"],
    "china": ["beijing", "shanghai"],
    "japan": ["tokyo", "hiroshima"]
};