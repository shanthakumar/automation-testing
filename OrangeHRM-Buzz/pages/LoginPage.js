export class LoginPage {

    loginData = JSON.parse(JSON.stringify(require("../test-data/login-data.json")))

    constructor(page) {
        this.page = page
        this.usernameTextbox = page.getByRole('textbox', {name: 'username'})
        this.passwordTextbox = page.getByPlaceholder('Password')
        this.loginButton = page.locator("//button[text()=' Login ']")
    }

    async load() {
        await this.page.goto("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
    }

    async login() {
        await this.usernameTextbox.fill(this.loginData.username)
        await this.passwordTextbox.fill(this.loginData.password)
        await this.loginButton.click()
    }
    
}