
export interface Product {
    "id"?: number,
    "artNum": string,
    "type": ProductType | undefined,
    model: string,
    size: ProductSize | undefined,
    color: string,
    price: number,
    stock?: number,
}

export enum ProductType {
    WINDSTOPPERS = 'windstoppers',
    JACKETS = 'jackets',
    PANTS = 'pants',
    VESTS = 'vests',
    RAINCOATS = 'raincoats',
    ACCESSORIES = 'accessories',
}


export enum ProductSize {
    XS = "XS",
    S = "S",
    M = "M",
    L = "L",
    XL = "XL",
}
