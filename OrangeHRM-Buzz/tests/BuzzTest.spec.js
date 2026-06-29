import test from '@playwright/test'
import { LoginPage } from '../pages/LoginPage'
import { DashboardPage } from '../pages/DashboardPage'
import { BuzzPage } from '../pages/BuzzPage.spec'

test('Test Buzz', async ({page}) => {

    const lp = new LoginPage(page)
    await lp.load()
    await lp.login()

    const dp = new DashboardPage(page)
    await dp.selectBuzz()

    const bp = new BuzzPage(page)
    await bp.post()
    await bp.verifyPost()
})



