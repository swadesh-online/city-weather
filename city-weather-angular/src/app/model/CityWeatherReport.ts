export class CityWeatherReport{
id ? : string;
city ?: string;
condition?: string;
localTime? : string;
maxTemperature? : string;
minTemperature? : string;
imageUrl? : string;

constructor(id?:string,city?:string, localTime?:string, condition?:string, maxTemperature?:string,minTemperature?:string,imageUrl?:string){
this.id=id;
this.city = city;
this.localTime = localTime;
this.condition = condition;
this.maxTemperature = maxTemperature;
this.minTemperature = minTemperature;
this.imageUrl = imageUrl;
}

}