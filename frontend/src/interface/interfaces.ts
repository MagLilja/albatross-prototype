interface StockInterface {
    id: number;
    amountInStock: number;
}

interface PhotoInterface {
    id: number;
    filename: string;
}

export interface ProductInterface {
    "id"?: number,
    "artNum": string,
    "type": ProductType | undefined | string,
    model: string,
    size: ProductSize | undefined,
    color: string,
    price: number,
    stock?: StockInterface,
    photoList?: PhotoInterface[]
}

export enum ProductType {
    WINDSTOPPERS = 'windstoppers',
    JACKETS = 'jackets',
    PANTS = 'pants',
    VESTS = 'vests',
    RAINCOATS = 'raincoats',
    ACCESSORIES = 'accessories',
    ALL = 'all'
}


export enum ProductSize {
    XS = "XS",
    S = "S",
    M = "M",
    L = "L",
    XL = "XL",
}
