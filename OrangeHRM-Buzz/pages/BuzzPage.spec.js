import { expect } from '@playwright/test'

export class BuzzPage {

    postMessage = "Good Testing"

    constructor(page) {
        this.page = page
        this.whatsOnYourMind = page.getByPlaceholder("What's on your mind?")
        this.postButton = page.getByRole('button', { name: ' Post ', exact: true })
        this.recentPostText = page.locator("(//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text'])[1]");
    }

    async post() {
        await this.whatsOnYourMind.fill(this.postMessage)
        await this.postButton.click()
    }

    async verifyPost() {
        await expect(this.recentPostText).toHaveText(this.postMessage)
    }
}