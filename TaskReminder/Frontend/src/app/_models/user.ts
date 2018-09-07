export class User {
  private _id: number;
  private _username: string;
  private _password: string;
  constructor(id: number, username: string, password: string) {
    this._id = id;
    this._username = username;
    this._password = password;
  }

  get id(): number {
    return this._id;
  }
  get username(): string {
    return this._username;
  }

  public isValidLogin(user: User) {
    return (this.username === user.username) && (this._password === user._password);
  }
}
