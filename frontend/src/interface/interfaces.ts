export interface Product {
    "id": number,
    "artNum": string,
    "type": string,
    model: string,
    size: string,
    color: string,
    price: number,
}

export enum ProductType {
    WINDSTOPPERS,
    RAINCOATS,
    JACKETS,
    PANTS,
    VESTS,
    ACCESSORIES
}