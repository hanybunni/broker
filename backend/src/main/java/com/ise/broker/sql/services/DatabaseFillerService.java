package com.ise.broker.sql.services;

import java.util.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.ise.broker.sql.entities.Account;
import com.ise.broker.sql.entities.Asset;
import com.ise.broker.sql.entities.CurrentlyOwnedAssets;
import com.ise.broker.sql.entities.Investor;
import com.ise.broker.sql.repositories.AccountRepository;
import com.ise.broker.sql.repositories.AssetRepository;
import com.ise.broker.sql.repositories.CurrentlyOwnedAssetsRepository;
import com.ise.broker.sql.repositories.InvestorRepository;

@Service
public class DatabaseFillerService {

    @Autowired
    private final InvestorRepository investorRepository;
    private final AccountRepository accountRepository;
    private final AssetRepository assetRepository;
    private final CurrentlyOwnedAssetsRepository currentlyOwnedAssetsRepository;

    private static final int INVESTOR_AMOUNT = 30;
    private static final int MIN_ACCOUNTS_PER_INVESTOR = 1; 
    private static final int MAX_ACCOUNTS_PER_INVESTOR = 5;
    private static final int MAX_OWNED_ASSETS_PER_ACCOUNT = 10;

    public DatabaseFillerService(InvestorRepository investorRepository, AccountRepository accountRepository, AssetRepository assetRepository, CurrentlyOwnedAssetsRepository currentlyOwnedAssetsRepository) {
        this.investorRepository = investorRepository;
        this.accountRepository = accountRepository;
        this.assetRepository = assetRepository;
        this.currentlyOwnedAssetsRepository = currentlyOwnedAssetsRepository;
    }

    public void fillDatabase() {
        List<Investor> investors = insertInvestors();
        List<Account> accounts = insertAccounts(investors);
        List<Asset> assets = insertAssets(accounts);
        insertCurrentlyOwnedAssets(accounts, assets);
    }

    private List<Investor> insertInvestors() {
        List<Investor> investors = new ArrayList<>();

        for (int i = 0; i < INVESTOR_AMOUNT; i++) {
            var name = Faker.instance().name();
            var address = Faker.instance().address();
            var email = name.firstName() + "." + name.lastName() + "@gmail.com";
            var phone = Faker.instance().phoneNumber();
            var citizenship = Faker.instance().country();

            Investor investor = new Investor();
            
            investor.setName(name.fullName());
            investor.setAddress(address.fullAddress());
            investor.setEmail(email);
            investor.setPhone(phone.phoneNumber());
            investor.setCitizenship(citizenship.countryCode2());

            investors.add(investor);
        }

        investorRepository.saveAll(investors);
        return investors;
    }

    private List<Account> insertAccounts(List<Investor> investors) {
        Faker faker = new Faker();
        List<Account> accounts = new ArrayList<>();

        String[] accountTypes = {"Joint", "Corporate", "Individual"};
        
        for(Investor investor : investors) {
            int randomNumberOfAccounts = faker.number().numberBetween(MIN_ACCOUNTS_PER_INVESTOR, MAX_ACCOUNTS_PER_INVESTOR);
            
            for(int i = 0; i < randomNumberOfAccounts; i++) {
                Account account = new Account();

                var currency = faker.currency();
                String type = faker.options().option(accountTypes);

                account.setCurrency(currency.code());
                account.setType(type);
                account.setInvestor(investor);

                accounts.add(account);
            }
        }

        accountRepository.saveAll(accounts);
        return accounts;
    }

    private List<Asset> insertAssets(List<Account> accounts) {
        Faker faker = new Faker();

        String[] tickers = {"APPL", "MSFT", "NVDA", "GOOGL", "META", "TSLA",  "GME", "AMD", "DELL", "LULU"};
        String[] names = {"Apple Inc", "Microsoft Corporation", "Nvidia Corporation", "Alphabet Inc", "Meta Platforms Inc", "Tesla Inc", "Gamestop Corp", "Advanced Micro Devices Inc", "Dell Technologies", "Lululemon Athletica"};
        
        List<Asset> assets = new ArrayList<>();
    
        for(int i = 0; i < tickers.length; i++) {
            Asset asset = new Asset();
            String ticker = tickers[i];
            String name = names[i];
            double price = faker.number().randomDouble(2, 50, 250);
            
            asset.setTicker(ticker);
            asset.setName(name);
            asset.setPrice(price);
                
            assets.add(asset);
        }
        
        assetRepository.saveAll(assets);
        return assets;
    }

    private void insertCurrentlyOwnedAssets(List<Account> accounts, List<Asset> assets) {
        Faker faker = new Faker();

        for (Account account : accounts) {
            int numberOfOwnedAssets = faker.number().numberBetween(0, MAX_OWNED_ASSETS_PER_ACCOUNT);
            List<Asset> ownedAssets = getRandomUniqueAssets(assets, numberOfOwnedAssets);

            for (Asset asset : ownedAssets) {
                CurrentlyOwnedAssets currentlyOwnedAsset = new CurrentlyOwnedAssets();
                currentlyOwnedAsset.setAccount(account);
                currentlyOwnedAsset.setAsset(asset);
                currentlyOwnedAsset.setNo_of_shares(faker.number().numberBetween(1, 1000));
                currentlyOwnedAsset.setAvg_price(faker.number().randomDouble(2, 10, 500));
                currentlyOwnedAssetsRepository.save(currentlyOwnedAsset);
            }
        }
    }

private List<Asset> getRandomUniqueAssets(List<Asset> assets, int numberOfAssets) {
    List<Asset> shuffledAssets = new ArrayList<>(assets);
    Collections.shuffle(shuffledAssets);

    Set<Asset> selectedAssets = new HashSet<>();
    List<Asset> randomAssets = new ArrayList<>();

    for (Asset asset : shuffledAssets) {
        if (selectedAssets.size() >= numberOfAssets) {
            break; // Stop if enough unique assets were selected
        }
        selectedAssets.add(asset);
        randomAssets.add(asset);
    }

    return randomAssets;
}
    
}
