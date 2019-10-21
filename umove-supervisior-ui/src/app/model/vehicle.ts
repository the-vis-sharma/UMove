import { VehicleType } from './vehicle-type';

export class Vehicle{
  public id: string;
  public zoneid: string;
  public insuranceNo: string;
  public status: string;
  public registrationNo: String;
  public type: VehicleType;
  public lastServiceDate: Date;
  public vehiclePurchased: Date;
}
