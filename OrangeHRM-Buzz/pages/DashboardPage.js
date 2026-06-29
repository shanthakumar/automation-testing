export class DashboardPage {
    constructor(page)
    {
        this.page = page
        this.buzzLink = page.getByRole('link').filter({hasText: 'Buzz'})
    }

    async selectBuzz() {
        await this.buzzLink.hover()
        await this.buzzLink.click()
    }
}