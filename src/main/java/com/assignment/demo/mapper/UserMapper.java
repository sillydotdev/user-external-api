package com.assignment.demo.mapper;

import com.assignment.demo.dto.*;
import com.assignment.demo.entity.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//@Mapper(componentModel = "spring")
@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMaidenName(user.getMaidenName());
        userDto.setAge(user.getAge());
        userDto.setGender(user.getGender());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setImage(user.getImage());
        userDto.setBloodGroup(user.getBloodGroup());
        userDto.setHeight(user.getHeight());
        userDto.setWeight(user.getWeight());
        userDto.setEyeColor(user.getEyeColor());
        userDto.setHair(toHairDto(user.getHair()));
        userDto.setIp(user.getIp());
        userDto.setAddress(toAddressDto(user.getAddress()));
        userDto.setMacAddress(user.getMacAddress());
        userDto.setUniversity(user.getUniversity());
        userDto.setBank(toBankDto(user.getBank()));
        userDto.setCompany(toCompanyDto(user.getCompany()));
        userDto.setEin(user.getEin());
        userDto.setSsn(user.getSsn());
        userDto.setUserAgent(user.getUserAgent());
        userDto.setCrypto(toCryptoDto(user.getCrypto()));
        userDto.setRole(user.getRole());

        return userDto;
    }

    public User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMaidenName(userDto.getMaidenName());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setBirthDate(userDto.getBirthDate());
        user.setImage(userDto.getImage());
        user.setBloodGroup(userDto.getBloodGroup());
        user.setHeight(userDto.getHeight());
        user.setWeight(userDto.getWeight());
        user.setEyeColor(userDto.getEyeColor());
        user.setHair(toHairEntity(userDto.getHair()));
        user.setIp(userDto.getIp());
        user.setAddress(toAddressEntity(userDto.getAddress()));
        user.setMacAddress(userDto.getMacAddress());
        user.setUniversity(userDto.getUniversity());
        user.setBank(toBankEntity(userDto.getBank()));
        user.setCompany(toCompanyEntity(userDto.getCompany()));
        user.setEin(userDto.getEin());
        user.setSsn(userDto.getSsn());
        user.setUserAgent(userDto.getUserAgent());
        user.setCrypto(toCryptoEntity(userDto.getCrypto()));
        user.setRole(userDto.getRole());

        return user;
    }

    public List<UserDto> toDtoList(List<User> userList) {
        if (userList == null) {
            return null;
        }
        return userList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<User> toEntityList(List<UserDto> userDtoList) {
        if (userDtoList == null) {
            return null;
        }
        return userDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    // Helper methods for nested objects
    private HairDto toHairDto(Hair hair) {
        if (hair == null) {
            return null;
        }
        HairDto hairDto = new HairDto();
        hairDto.setColor(hair.getColor());
        hairDto.setType(hair.getType());
        return hairDto;
    }

    private Hair toHairEntity(HairDto hairDto) {
        if (hairDto == null) {
            return null;
        }
        Hair hair = new Hair();
        hair.setColor(hairDto.getColor());
        hair.setType(hairDto.getType());
        return hair;
    }

    private AddressDto toAddressDto(Address address) {
        if (address == null) {
            return null;
        }
        AddressDto addressDto = new AddressDto();
        addressDto.setAddress(address.getAddress());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setStateCode(address.getStateCode());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setCoordinates(toCoordinatesDto(address.getCoordinates()));
        addressDto.setCountry(address.getCountry());
        return addressDto;
    }

    private Address toAddressEntity(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }
        Address address = new Address();
        address.setAddress(addressDto.getAddress());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setStateCode(addressDto.getStateCode());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCoordinates(toCoordinatesEntity(addressDto.getCoordinates()));
        address.setCountry(addressDto.getCountry());
        return address;
    }

    private CoordinatesDto toCoordinatesDto(Coordinates coordinates) {
        if (coordinates == null) {
            return null;
        }
        CoordinatesDto coordinatesDto = new CoordinatesDto();
        coordinatesDto.setLat(coordinates.getLat());
        coordinatesDto.setLng(coordinates.getLng());
        return coordinatesDto;
    }

    private Coordinates toCoordinatesEntity(CoordinatesDto coordinatesDto) {
        if (coordinatesDto == null) {
            return null;
        }
        Coordinates coordinates = new Coordinates();
        coordinates.setLat(coordinatesDto.getLat());
        coordinates.setLng(coordinatesDto.getLng());
        return coordinates;
    }

    private BankDto toBankDto(Bank bank) {
        if (bank == null) {
            return null;
        }
        BankDto bankDto = new BankDto();
        bankDto.setCardExpire(bank.getCardExpire());
        bankDto.setCardNumber(bank.getCardNumber());
        bankDto.setCardType(bank.getCardType());
        bankDto.setCurrency(bank.getCurrency());
        bankDto.setIban(bank.getIban());
        return bankDto;
    }

    private Bank toBankEntity(BankDto bankDto) {
        if (bankDto == null) {
            return null;
        }
        Bank bank = new Bank();
        bank.setCardExpire(bankDto.getCardExpire());
        bank.setCardNumber(bankDto.getCardNumber());
        bank.setCardType(bankDto.getCardType());
        bank.setCurrency(bankDto.getCurrency());
        bank.setIban(bankDto.getIban());
        return bank;
    }

    private CompanyDto toCompanyDto(Company company) {
        if (company == null) {
            return null;
        }
        CompanyDto companyDto = new CompanyDto();
        companyDto.setDepartment(company.getDepartment());
        companyDto.setName(company.getName());
        companyDto.setTitle(company.getTitle());
        companyDto.setAddress(toAddressDto(company.getAddress()));
        return companyDto;
    }

    private Company toCompanyEntity(CompanyDto companyDto) {
        if (companyDto == null) {
            return null;
        }
        Company company = new Company();
        company.setDepartment(companyDto.getDepartment());
        company.setName(companyDto.getName());
        company.setTitle(companyDto.getTitle());
        company.setAddress(toAddressEntity(companyDto.getAddress()));
        return company;
    }

    private CryptoDto toCryptoDto(Crypto crypto) {
        if (crypto == null) {
            return null;
        }
        CryptoDto cryptoDto = new CryptoDto();
        cryptoDto.setCoin(crypto.getCoin());
        cryptoDto.setWallet(crypto.getWallet());
        cryptoDto.setNetwork(crypto.getNetwork());
        return cryptoDto;
    }

    private Crypto toCryptoEntity(CryptoDto cryptoDto) {
        if (cryptoDto == null) {
            return null;
        }
        Crypto crypto = new Crypto();
        crypto.setCoin(cryptoDto.getCoin());
        crypto.setWallet(cryptoDto.getWallet());
        crypto.setNetwork(cryptoDto.getNetwork());
        return crypto;
    }
}
